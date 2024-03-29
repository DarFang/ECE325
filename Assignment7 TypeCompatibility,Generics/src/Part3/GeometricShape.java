package Part3;
/**
 * Assignment 7: Type Compatibility and Generics <br />
 * The {@code GeometricShape} interface for all kinds of geometric shapes
 */
public interface GeometricShape {
    public void describe();
    public <T extends GeometricShape> T supersize();
}
