# Laboratory work №1
### **Task:** Create a picture by option using graphic primitives in the JavaFX library.

#### **Creating individual primitives:**

1. **Line:**
      ```
      Line line = new Line(0.0f, 0.0f, 100.0f, 100.0f);
      ```
      *or*
      ```
      Line line = new Line();
      line.setStartX(0.0f);
      line.setStartY(0.0f);
      line.setEndX(100.0f);
      line.setEndY(100.0f);
      ```

2. **Rectangle:**
      ```
      Rectangle r = new Rectangle(50,50,200,100);
      ```
      *or*
      ```
      Rectangle r = new Rectangle();
      r.setX(50);
      r.setY(50);
      r.setWidth(200);
      r.setHeight(100);
      ```

3. **Circle:**
      ```
      Circle circle = new Circle(100,100,50);
      ```
      *or*
      ```
      Circle circle = new Circle();
      circle.setCenterX(100.0f);
      circle.setCenterY(100.0f);
      circle.setRadius(50.0f);
      ```

4. **Polygon:**
      ```
      Polygon polygon = new Polygon(0, 0, 20, 10, 10, 20);
      ```
      *or*
      ```
      Polygon polygon = new Polygon();
      polygon.getPoints().addAll(new Double[]{
       0.0, 0.0,
       20.0, 10.0,
       10.0, 20.0 });
      ```
      *or*
      ```
      polygon.getPoints().add(0.0);
      polygon.getPoints().add(0.0);
      polygon.getPoints().add(20.0);
      polygon.getPoints().add(10.0);
      polygon.getPoints().add(10.0);
      polygon.getPoints().add(20.0);
      ```

5. **Polyline:**
      ```
      Polyline polyline = new Polyline(0.0, 0.0, 20.0, 10.0, 10.0, 20.0);
      ```
      *or*
      ```
      Polyline polyline = new Polyline();
      polyline.getPoints().addAll(new Double[]{
       0.0, 0.0,
       20.0, 10.0,
       10.0, 20.0 });
      ```

6. **Ellipse:** 
      ```
      Ellipse ellipse = new Ellipse(50,50,50,25);
      ```
      *or*
      ```
      Ellipse ellipse = new Ellipse();
      ellipse.setCenterX(50.0f);
      ellipse.setCenterY(50.0f);
      ellipse.setRadiusX(50.0f);
      ellipse.setRadiusY(25.0f);
      ```
      
