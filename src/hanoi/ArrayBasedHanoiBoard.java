package hanoi;

/**
 * A {@link ArrayBasedHanoiBoard} is a simple implementation of
 * {@link HanoiBoard}
 * 
 * @author jcollard
 * 
 */
public class ArrayBasedHanoiBoard implements HanoiBoard {
	/**
	 * Creates a {@link ArrayBasedHanoiBoard} with three empty {@link HanoiPeg}s
	 * and {@code n} rings on peg 0.
	 */
	
	StackBasedHanoiPeg firstPeg = new StackBasedHanoiPeg();
	StackBasedHanoiPeg middlePeg = new StackBasedHanoiPeg();
	StackBasedHanoiPeg endPeg = new StackBasedHanoiPeg();
	
	StackBasedHanoiPeg[] towers = new StackBasedHanoiPeg[3];
	
	public ArrayBasedHanoiBoard(int n) throws IllegalArgumentException{
		if(n<0)
			throw new IllegalArgumentException();
		
		HanoiRing ring;
		while(n>0){
			ring = new HanoiRing(n);
			firstPeg.addRing(ring);
			n-=1;
		}
		towers[0] = firstPeg;
		towers[1] = middlePeg;
		towers[2] = endPeg;
	}

	@Override
	public void doMove(HanoiMove move) throws IllegalHanoiMoveException {
		if (!isLegalMove(move) || towers[move.getFromPeg()]==null)
			throw new IllegalHanoiMoveException("Could not perform illegal move.");
		//add top ring from "fromPeg" onto top of "toPeg)
		//remove top of "fromPeg"
		towers[move.getToPeg()].addRing(towers[move.getFromPeg()].getTopRing());
		towers[move.getFromPeg()].remove();
	}

	@Override
	public boolean isSolved() {
		
		if(towers[0].hasRings() || towers[1].hasRings())
			return false;
		return true;
	}

	@Override
	public boolean isLegalMove(HanoiMove move) throws NullPointerException{
		if(move == null)
			throw new NullPointerException();
		
		if(!towers[move.getFromPeg()].hasRings())
			return false;
		
		if(!towers[move.getToPeg()].hasRings())
			return true;
		
		if(towers[move.getFromPeg()].getTopRing().getSize()>=towers[move.getToPeg()].getTopRing().getSize())
			return false;
		
		return true;
	}
}
