package com.lopina.exercises.dynamic.editdistance;

public final class DefaultEditDistancePenaltyStrategy implements
		EditDistancePenaltyStrategy {

	@Override
	public int getPenaltyForReplace() {
		return 1;
	}

	@Override
	public int getPenaltyForDelete() {
		return 1;
	}

	@Override
	public int getPenaltyForInsert() {
		return 1;
	}

}
