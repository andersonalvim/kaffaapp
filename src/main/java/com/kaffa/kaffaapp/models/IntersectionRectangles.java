package com.kaffa.kaffaapp.models;

public class IntersectionRectangles {
	
	public static boolean isThereIntersection(int r1x1, int r1y1, int r1x2, int r1y2, int r2x1, int r2y1, int r2x2, int r2y2) {
		
		if(r1x1 < (r2x1 + r2x2) && (r1x1 + r1x2) >  r2x1 && r1y1 < (r2y1 + r2y2) && (r1y1 + r1y2) > r2y1) {
			return true;
		}else {
			return false;
		}
		
		/*
		 * if int(rect1.get("x")) < int(rect2.get("x")) + int(rect2.get("width")) and \
        	int(rect1.get("x")) + int(rect1.get("width")) > int(rect2.get("x")) and \
        	int(rect1.get("y")) < int(rect2.get("y")) + int(rect2.get("height")) and \
        	int(rect1.get("y")) + int(rect1.get("height")) > int(rect2.get("y")):
    			print("Há intersecção!")
			else:
    			print("Não há intersecção!")
		 * 
		 */
		
	}

}
