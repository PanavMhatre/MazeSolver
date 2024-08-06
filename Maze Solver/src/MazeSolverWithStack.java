
public class MazeSolverWithStack extends MazeSolver {
	
	MyStack stack;

	public MazeSolverWithStack(Maze m) {
		super(m);
		stack = new MyStack();
		add(maze.getExit());
		add(maze.getStart());     
	}

	@Override
	void makeEmpty() {
		stack.clear();
	}

	@Override
	boolean isEmpty() {
		return stack.size()==0;
	}

	@Override
	void add(Square s) {
		stack.push(s);
		
	}

	@Override
	Square next() {
		return stack.pop();
	}

	@Override
	String getPath() {
		if(!unSolvable) {
			return "Not yet solved";
		}else if(isSolved()) {
			return "Solved";
		}else {
			return "Unsolvable";
		}
	}

	@Override
	void solve() {
		while(!isSolved()) {
			System.out.println("In Solving");
			step();
			if(isEmpty()) {      
				unSolvable=true; 
            }                 
		}
		
		
	}

}
