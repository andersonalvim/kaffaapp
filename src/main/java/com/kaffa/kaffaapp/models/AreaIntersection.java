package com.kaffa.kaffaapp.models;

public class AreaIntersection {

	public static int areaIntersection(int K, int L, int M, int N, int P, int Q, int R, int S) {
		
		int interseccao = 0;
		
		int esquerda = Math.max(K,P);
		int direita = Math.min(M+1,R+1); /*the points are included in the rectangle and have a dimension of 1 unit; the rectangle (0, 0; 1, 1) have an area of 4 units.*/
		int base = Math.max(L,Q);
		int topo = Math.min(N+1,S+1); /*the points are included in the rectangle and have a dimension of 1 unit; the rectangle (0, 0; 1, 1) have an area of 4 units.*/
		
		if(esquerda < direita && base < topo) {
			interseccao = (direita - esquerda) * (topo - base);
			System.out.println(interseccao);
			return interseccao;
		}else {
			return interseccao;
		}
		
	}
	
}
