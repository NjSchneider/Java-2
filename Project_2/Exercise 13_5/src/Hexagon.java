public class Hexagon extends GeometricObject 
{
    private int sideSize;
    
   /**
    * default no-arg constructor
    */   
    public Hexagon()
    { }
    /**
     * 
     * @param sideSize 
     */
    public Hexagon(int sideSize)
    {
        this.sideSize = sideSize;
    }
    
    /** Sets the sideSize */
    public void setSideSize(int sideSize)
    {
        this.sideSize = sideSize;
    }
    
    /** Returns sideSize */
    public int getSideSize()
    {
        return sideSize;
    }
    
    @Override /** Return area */
    public double getArea()
    {
        return sideSize*60;
    }
    
    @Override /** Return perimeter */
    public double getPerimeter()
    {
        return sideSize*6.0;
    }    

}
