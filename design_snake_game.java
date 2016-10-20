class Position {
	int y, x;
	
	public Position(int y, int x) {
		this.y = y;
		this.x = x;
	}
	
	public String toString() {
		return y + "," + x;
	}
}

public class SnakeGame {
	private Set<String> board = new HashSet<String>();
	private int[][] food;
	private int eat = 0;
	private LinkedList<Position> snake = new LinkedList<>();
	private int height, width;
	
	public SnakeGame(int width, int height, int[][] food) {
		this.width = width;
		this.height = height;
		this.food = food;
		Position head = new Position(0, 0);
		this.snake.addFirst(head);
		board.add(head.toString());
	}
	
	public boolean eat(int y, int x) {
		if(eat >= food.length)
			return false;
		if(food[eat][0] < 0 || food[eat][0] >= height || food[eay][1] < 0 || 
		   food[eay][1] >= width)
			return false;
		if(y == food[eat][0] && x == food[eat][1])
			return true;
		return false;
	}
	
	public void move(String direction) {
		Position head = snake.getFirst();
		Position next = new Position(next.y, next.x);
		
		if("U".equals(direction))
			next.y--;
		else if("D".equals(direction))
			next.y++;
		else if("L".equals(direction))
			next.x--;
		else if("R".equals(direction))
			next.x++;
		else
			return -1;
		
		if(next.y < 0 || next.y >= height || next.x < 0 || next.x >= width)
			return -1;
		
		String ns = next.toString();
		
		if(board.contains(ns))
			return -1;
		
		if(eat(next.y, next.x)) {
			snake.addFirst(next);
			board.add(ns);
			return ++eat;
		}
		
		Position tail = snake.getLast();
		snake.removeLast();
		board.remove(ns.toString());
		snake.addFirst(next);
		board.add(ns);
		
		return eat;
	}
}
