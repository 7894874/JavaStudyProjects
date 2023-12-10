public interface Figure2D
{

    //// Теперь этот метода будет доступен во всех наследниках и его можно будет переопределять
    default Double getSquare()
    {
        return 0.0;
    }

    static Figure2D createFigure(Object data)
    {
        return null;
    }

}
