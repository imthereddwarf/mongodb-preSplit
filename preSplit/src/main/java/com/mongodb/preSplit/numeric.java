package com.mongodb.preSplit;

public class numeric {
	public static boolean equals(Object one, Object two) {
		if ((one instanceof Long || one instanceof Integer) &&
			(two instanceof Long || two instanceof Integer)) {
			if (getLValue(one).equals(getLValue(two)))
				return(true);
			else 
				return(false);
		}
		else {
			Double valOne = getDValue(one);
			Double valTwo = getDValue(two);
			if (valOne.isNaN() || valTwo.isNaN())
				return(false);
			if (valOne.equals(valTwo))
				return(true);
		} 
		return(false);
	}
	static Double getDValue(Object in) {
		if (in instanceof Long)
			return ((Long)in).doubleValue();
		if (in instanceof Integer)
			return ((Integer)in).doubleValue();
		if (in instanceof Double)
			return (Double)in;
		return(Double.NaN);
	}
	
	static Long getLValue(Object in) {
		if (in instanceof Long)
			return (Long)in;
		if (in instanceof Integer)
			return ((Integer)in).longValue();
		else
			return ((Double)in).longValue();
	}
	
	static String asString(Object in) {
		if (in instanceof Long)
			return ((Long)in).toString();
		if (in instanceof Integer)
			return ((Integer)in).toString();
		if (in instanceof String)
			return "\""+(String)in+"\"";
		if (in instanceof Double)
			return String.format( "%.1f", (Double)in );
		if (in == null)
			return("null");
		else
			return in.toString();
	}

}
