package utils.layout;

public interface LayoutManip {
    Layout CentroSymmetry(Layout orig);
    Layout InversionSymmetry(Layout orig);
    Layout ReversionSymmetry(Layout orig);
    Layout Combination(Layout... origs);
    Layout Intersection(Layout... origs);
}
