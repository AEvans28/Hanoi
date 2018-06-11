package hanoi;

import structures.LinkedStack;

/**
 * A {@link StackBasedHanoiPeg} is an implementation of {@link HanoiPeg}.
 * 
 * @author jcollard
 */
public class StackBasedHanoiPeg implements HanoiPeg {

	LinkedStack<HanoiRing> stack = new LinkedStack<HanoiRing>();
	
	
	/**
	 * Creates a new {@link StackBasedHanoiPeg} that has no rings.
	 */
	public StackBasedHanoiPeg() {
	}
	
	@Override
	public void addRing(HanoiRing ring) throws IllegalHanoiMoveException {
		if( ring.getSize() < 0 || ring == null)
			throw new IllegalHanoiMoveException("Illegal Move");
		
		if(!hasRings())
			stack.push(ring);
		
		else if(ring.getSize() >= stack.peek().getSize())
			throw new IllegalHanoiMoveException("Illegal Move");
		
		else
			stack.push(ring);
	} 

	@Override
	public HanoiRing remove() throws IllegalHanoiMoveException {
		if(!hasRings())
			throw new IllegalHanoiMoveException("Illegal Move");
		return stack.pop();
	}
	
	@Override
	public HanoiRing getTopRing() throws IllegalHanoiMoveException {
		if(!hasRings())
			throw new IllegalHanoiMoveException("Illegal Move");
		return stack.peek();
	}

	@Override
	public boolean hasRings() {
		return (!stack.isEmpty());
	}
	
	
}
