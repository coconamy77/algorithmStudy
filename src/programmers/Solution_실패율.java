package programmers;

class Stage implements Comparable<Stage>{
	int stage;
    int players;
    int fail;
    
    double fRate;

	@Override
	public int compareTo(Stage o) {
		if(this.fRate>o.fRate) {
			return -1;
		}
		if(o.fRate>this.fRate) {
			return 1;
		}
		if(this.stage<o.stage) {
			return -1;
		}
		return 1;
	}
}
