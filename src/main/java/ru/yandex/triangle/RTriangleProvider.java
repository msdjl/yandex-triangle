package ru.yandex.triangle;

public final class RTriangleProvider {
    public static Rtriangle getRtriangle() {
        return new SomeTriangle();
    }
}