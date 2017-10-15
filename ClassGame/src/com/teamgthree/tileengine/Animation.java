package com.teamgthree.tileengine;

public class Animation {
	private int startFrame;
	private int stopFrame;
	private int currentFrame;
	
	public int getCurrentFrame() {
		return currentFrame;
	}

	public void setCurrentFrame(int currentFrame) {
		this.currentFrame = currentFrame;
	}

	public Animation(int startFrame, int stopFrame) {
		this.currentFrame = startFrame;
		this.startFrame = startFrame;
		this.stopFrame = stopFrame;
	}

	public void animate() {
		
		//System.out.println(this.stopFrame);
		
		if (this.currentFrame ==  this.stopFrame) {
			//System.out.println("RESETT FRAME");
			this.currentFrame = this.startFrame;
		} else {
			//System.out.println("INCREMENT FRAME");
			this.currentFrame++;
		}
	}
}
