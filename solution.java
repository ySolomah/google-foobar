package com.google.challenges; 

public class Answer {
    public static int answer(int n) { 
        int[][] solutions = new int[n+1][n+1];
        for(int i = 0; i < n+1; i++) {
            for(int j = 0; j < n+1; j++) {
                solutions[i][j] = 0; //init
                int maxBrick = (j)*(j+1)/2; //max possible bricks with j height is just the sum equation
                if(i == 0 || j == 0 || i > maxBrick) { //no bricks, no height, too many bricks for our max height
                    solutions[i][j] = 0;
                    continue;
                }
                else if(i == j) {
                    solutions[i][j] = 1;
                }
                
                if(maxBrick == i) {
                    solutions[i][j] = 1;
                }
                else if(i < maxBrick){ ///should also be else
                    for(int k = Math.min(i,j); k >= 1; k--) {
                        solutions[i][j] += solutions[i-k][k-1];
                    }
                    solutions[i][j] = Math.max(solutions[i][j], solutions[i][j-1]);
                }
            }
        }
        return(solutions[n][n] - 1); // remove the case of just n bricks stacked high
    }
}
