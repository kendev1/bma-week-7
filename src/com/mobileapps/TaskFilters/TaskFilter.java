package com.mobileapps.TaskFilters;
import com.mobileapps.Tasks.Assignment;

public interface TaskFilter {

	/**
	 * @param args
	 */


public Assignment.Task[] sortbydate(Assignment.Task[] tasks, boolean dateflag);
public Assignment.Task[] sortbydoctor(Assignment.Task[] tasks, boolean alphaflag);

	

		


}
