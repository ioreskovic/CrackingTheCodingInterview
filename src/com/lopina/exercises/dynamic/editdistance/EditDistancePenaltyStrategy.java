package com.lopina.exercises.dynamic.editdistance;

public interface EditDistancePenaltyStrategy {
	int getPenaltyForReplace();
	int getPenaltyForDelete();
	int getPenaltyForInsert();
}
