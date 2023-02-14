package ch10;

import java.util.ArrayList;
import java.util.List;

public class ShapeTest {
    public static void main(String[] args) {
        List<Shape> rectagles = findShapesByType(Shape.shapes, "사각형");
        System.out.print("사각형 : ");
        System.out.println(rectagles);
        List<Shape> redNSmallShapes = findShapesByColorNArea(Shape.shapes, "빨간색", 12.0);
        System.out.print("빨간 도형(면적<=12.0) : ");
        System.out.println(redNSmallShapes);
    }

    static List<Shape> findShapesByType(List<Shape> shapes, String type) {
        List<Shape> result = new ArrayList<>();

        for (Shape s : shapes) {
            if (s.getType().equals(type))
                result.add(s);
        }
        return result;
    }

    static List<Shape> findShapesByColorNArea(List<Shape> shapes, String color, Double area) {
        List<Shape> result = new ArrayList<>();

        for (Shape s : shapes) {
            if (s.getColor().equals(color) && s.getArea() <= area)
                result.add(s);
        }
        return result;
    }
}
