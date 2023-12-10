import java.io.File;

public class Distortion {

    private  File[] files;
    private double qttOffiles;
    private double currentProcessor;
    private double privPositionOfFiles;
    private double qttOfProcessors;
    private double resultFilesPart;

    public Distortion(double qttOffiles, double qttOfProcessors, double currentProcessor, double privPositionOfFiles) {

        this.qttOffiles = qttOffiles;
        this.qttOfProcessors = qttOfProcessors;
        this.currentProcessor = currentProcessor;
        this.privPositionOfFiles = privPositionOfFiles;
        this.resultFilesPart = getcalculatePostionOfFiles();

    }

    public int getResultFilesPart() {
        return (int) resultFilesPart;
    }

    public int getcalculatePostionOfFiles()
    {
        double resultFilesPart = Math.ceil(currentProcessor / qttOfProcessors *  qttOffiles - privPositionOfFiles);

        return (int) resultFilesPart;
    }


}
