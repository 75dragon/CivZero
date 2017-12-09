package Map;

import java.util.Random;

import Tiles.Tile;
import Tiles.WaterTile;


public class Generate
{
    String[][] world;
    
    String[][] holdPattern;
    
    String[][] resource;
    
    Tile[][] gameWorld;

    int[][] numbers;

    int col, row;

    Random rand;

    int iE = 0;

    int jE = 0;


    public Generate( int x, int y )
    {
        rand = new Random();
        row = y;
        col = x;
        world = new String[x][y];
        // makeTestWorld2();
        makeWorld(60, "#");
        printWorld();
        iterateWorld("#");
        printWorld();
        //iterateWorld();
        //finalTouch();
        //printWorld();
    }
    public void firstConvert()
    {
    	for ( int i = 0; i < row; i++ )
        {
            for ( int j = 0; j < col; j++ )
            {
                if (world[i][j] == " ")
                {
                	gameWorld[i][j] = new WaterTile(i,j);
                }
                else
                {
                	int r = rand.nextInt( 4 );
                	if (r == 0)
                	{
                		
                	}
                }
            }
        }
    }

    public String[][] makeBlankWorld()
    {
        String[][] temp = new String[row][col];
        for ( int i = 0; i < row; i++ )
        {
            for ( int j = 0; j < col; j++ )
            {
                temp[i][j] = " ";
            }
        }
        return temp;
    }

    public String[][] makeWorld( int percent, String type )
    {
        String[][] temp = new String[row][col];
        for ( int i = 0; i < row; i++ )
        {
            for ( int j = 0; j < col; j++ )
            {
                if ( rand.nextInt( 99 ) + 1 <= percent )
                {
                    world[i][j] = type;
                }
                else
                {
                    world[i][j] = " ";
                }
            }
        }
        return temp;
    }

    void makeTestWorld2()
    {
        world = new String[row][col];
        for ( int i = 0; i < row; i++ )
        {
            for ( int j = 0; j < col; j++ )
            {
                world[i][j] = " ";
                if ( i == 2 && j == 2 )
                {
                    world[i][j] = "#";
                }
            }
        }
    }

    void printWorld()
    {
        System.out.println();
        System.out.println();
        for ( int i = 0; i < row; i++ )
        {
            for ( int j = 0; j < col; j++ )
            {
                System.out.print( world[i][j] );
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }


    void iterateWorld( String type )
    {
        numbers = new int[row][col];
        for ( int i = 0; i < row; i++ )
        {
            for ( int j = 0; j < col; j++ )
            {
                numbers[i][j] = getWall( i + 1, j + 1, type ) + getWall( i + 1, j, type ) + getWall( i + 1, j - 1, type )
                    + getWall( i, j + 1, type ) + getWall( i, j, type ) + getWall( i, j - 1, type ) + getWall( i - 1, j + 1, type )
                    + getWall( i - 1, j, type ) + getWall( i - 1, j - 1, type );
            }
        }

        for ( int i = 0; i < row; i++ )
        {
            for ( int j = 0; j < col; j++ )
            {
                if ( numbers[i][j] > 4 )
                {
                    world[i][j] = type;
                }
                else
                {
                    world[i][j] = " ";
                }
            }
        }
    }


    void finalTouch()
    {
        for ( int i = 0; i < row; i++ )
        {
            for ( int j = 0; j < col; j++ )
            {
                if ( world[i][j].equals( "M" ) )
                {
                    if ( rand.nextInt( 20 ) == 0 )
                    {
                        world[i][j] = "";
                    }
                    else if ( rand.nextInt( 10 ) == 0 )
                    {
                        world[i][j] = "S";
                    }
                }
                else if ( world[i][j].equals( " " ) )
                {
                    if ( rand.nextInt( 20 ) == 0 )
                    {
                        world[i][j] = "g";
                    }
                    else if ( rand.nextInt( 50 ) == 0 )
                    {
                        world[i][j] = "T";
                    }
                    else if ( rand.nextInt( 40 ) == 0 )
                    {
                        world[i][j] = "t";
                    }
                    else if ( rand.nextInt( 100 ) == 0 )
                    {
                        world[i][j] = "B";
                    }
                    else if ( rand.nextInt( 200 ) == 0 )
                    {
                        world[i][j] = "H";
                    }
                    else if ( rand.nextInt( 500 ) == 0 )
                    {
                        world[i][j] = "W";
                    }
                }
            }
        }
    }

    int getWall( int y, int x, String type )
    {
        if ( x >= col || x < 0 || y >= row || y < 0 )
        {
            return 0;
        }
        if ( world[y][x].equals( type ) )
        {
            return 1;
        }
        return 0;
    }

    public int distance( int x, int y )
    {
        return Math.abs( x - y );
    }
    
    public static void main(String args[])
    {
    	Generate bob = new Generate(10,10);
    }
}