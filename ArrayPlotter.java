/**
/**
 * lab 20
 * @author - Kyle Dodds
 * @author - S126416
 * @author - Period 5th
 * @author - I received help from ...
 *
 * 
 *
 * The ArrayPlotter class provides methods for drawing in
 *    a grid by setting the boolean values of a 2D array.
 *
 *    Each drawing method must
 *    - take zero arguments,
 *    - have a void return type, and
 *    - have a name that conforms to the on...ButtonClick format.
 *      (This restriction allows the GridPlotterGUI to recognize methods,
 *       for which it automatically generates buttons.)
 *
 * License Information:
 *   This class is free software; you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation.
 *
 *   This class is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 */

import javax.swing.JOptionPane;

public class ArrayPlotter
{
    /** The Array Plotter Graphical User Interface. */
    private ArrayPlotterGUI gui;

    /** The Color Array.  The element values indicate how to color a grid cell:
     *  - true: Color the cell with the Drawing Color.
     *  - false: Color the cell with the Background Color.
     */
    private boolean[][] colorArray;


    /** Constructs an Array Plotter */
    public ArrayPlotter()
    {
        gui = new ArrayPlotterGUI(this);
        colorArray = null;
    }

    /** Initialize this's Color Array to a new 2D array of boolean values
     *  with the given dimensions.
     *  @param rows the number of rows in the new array.
     *  @param cols the number of columns in the new array.
     *  Postcondition: All of the Color Array's elements have the value false.
     */
    public void initializeColorArray(int rows, int cols)
    {
       colorArray = new boolean[rows][cols];
    }
    /** Removes all objects from the grid. */
    public void onClearGridButtonClick()
    {
        for(int i = 0; i < colorArray.length; i++){
            for(int j = 0; j < colorArray[0].length; j++){
                colorArray[i][j]=false;
                gui.update(colorArray);
              }
          }
        
    }
    /** Fills in all the cells of the grid using a row-major traversal. */
    public void onRowMajorFillButtonClick()
    {

        for(int i = 0; i < colorArray.length; i++){
            for(int j = 0; j < colorArray[0].length; j++){
                colorArray[i][j]=true;
                gui.update(colorArray);
              }
          }
    }

    public void onColMajorFillButtonClick(){
        for(int i = 0; i < colorArray.length; i++){
            for(int j = 0; j < colorArray[0].length; j++){
                colorArray[j][i]=true;
                gui.update(colorArray);
              }
          }
    }

    public void onReverseRowMajorFillButtonClick(){
        for(int i = colorArray.length-1; i > -1; i--){
            for(int j = 0; j < colorArray[0].length; j++){
                colorArray[i][j]=true;
                gui.update(colorArray);
              }
          }
    }
    
    public void onReverseColumnMajorFillButtonClick(){
        for(int i = colorArray.length-1; i > -1; i--){
            for(int j = colorArray[0].length-1; j > -1; j--){
                colorArray[i][j]=true;
                gui.update(colorArray);
              }
          }
    }
    
     public void onMainDiagonalFillButtonClick(){
        int j = 0;
        for(int i = 0; i < colorArray.length; i++){
            colorArray[i][j]=true;
            gui.update(colorArray);
            j++;
          }
    }
    
    public void  onMainTriangleFillButtonClick(){
        for(int i = 0; i < colorArray.length; i++){
            for(int j = 0; j < i+1; j++){
                colorArray[i][j]=true;
                gui.update(colorArray);
               }
          }
    }
    
    public void onOtherDiagonalFillButtonClick(){
        int j = 0;
        for(int i = 0; i < colorArray.length; i++){
            colorArray[j][colorArray.length-i]=true;
            gui.update(colorArray);
            j++;
          }
    }
    /** main method that creates the grid plotter application. */
    public static void main(String[] args)
    {
        ArrayPlotter plotter = new ArrayPlotter();          
    }
}
