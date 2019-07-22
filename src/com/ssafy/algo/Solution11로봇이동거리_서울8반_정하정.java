package com.ssafy.algo;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution11로봇이동거리_서울8반_정하정 {
    static int T, N;
    static int Answer=0;
    
    static void count(char[][] a, int i, int j, int x, int y) {
        if (i+x>a.length-1 || i+x<0 || j+y>a.length-1 || j+y<0) {
            return;
        }
        if (a[i+x][j+y]=='S') {
            Answer++;
            count(a, i+x,j+y,x,y);
        }
    }

    public static void main(String[] args) throws Exception{
        
        //System.setIn(new FileInputStream("res/input.txt"));
        
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        
        for(int test_case = 1; test_case <= T; test_case++)    {
            N = sc.nextInt();
            char[][] map=new char[N][N];
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {                    
                    map[i][j] = sc.next().charAt(0);                
                }
            }
            for (int i=0; i<map.length;i++) {
                for (int j = 0; j<map.length;j++) {
                    switch(map[i][j]) {
                    case('A'):
                    	count(map,i,j,dx[0],dy[0]);
                        break;
                    case('B'):
                        count(map,i,j,dx[0],dy[0]);
                    	count(map,i,j,dx[2],dy[2]);
                        break;
                    case('C'):
                        count(map,i,j,dx[0],dy[0]);
                        count(map,i,j,dx[1],dy[1]);
                        count(map,i,j,dx[2],dy[2]);
                        count(map,i,j,dx[3],dy[3]);
                        break;
                    }
                    /*static void countC(char[][] a, int i, int j, int x, int y) {
                        if (i+x>a.length-1 || i+x<0 || j+y>a.length-1 || j+y<0) {
                            return;
                        }
                        if (a[i+x][j+y]=='S') {
                            Answer++;
                            countC(a, i+x,j+y,x,y);
                        }
                    }*/
                }
            }
            System.out.println("#"+test_case+" "+Answer);
            Answer=0;
        }
    }
}