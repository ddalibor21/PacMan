package sk.tsystems.happysnake.gamepanel;

public enum Direction {
	UP, RIGHT, DOWN, LEFT;
	
	private Direction val(int i) {
		int ord = this.ordinal()+i;
		if(ord>=Direction.values().length)
			ord = 0;

		if(ord<0)
			ord = Direction.values().length-1;
		
		return Direction.values()[ord];
	}
	
	public Direction next() {
		return val(1);
	}
	
	public Direction prev() {
		return val(-1);
	}

}
