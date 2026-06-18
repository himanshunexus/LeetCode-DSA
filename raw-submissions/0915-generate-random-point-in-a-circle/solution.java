class Solution {
    private double radius;
    private double x_center;
    private double y_center;
    private java.util.Random random;

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
        this.random = new java.util.Random();
    }
    
    public double[] randPoint() {
        double minX = x_center - radius;
        double maxX = x_center + radius;
        double minY = y_center - radius;
        double maxY = y_center + radius;
        
        while (true) {
            double x = minX + (maxX - minX) * random.nextDouble();
            double y = minY + (maxY - minY) * random.nextDouble();
            
            if ((x - x_center) * (x - x_center) + (y - y_center) * (y - y_center) <= radius * radius) {
                return new double[]{x, y};
            }
        }
    }
}
