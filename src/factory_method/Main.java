package factory_method;

interface Report{
    void generate();
}

class PDFReport implements Report {
    public void generate() {
        System.out.println("Generating PDF Report...");
    }
}

class ExcelReport implements Report {
    public void generate() {
        System.out.println("Generating Excel Report...");
    }
}

class HTMLReport implements Report {
    public void generate() {
        System.out.println("Generating HTML Report...");
    }
}

abstract class ReportCreator{
    public abstract Report createReport();
    
    public void generateReport() {
        Report report = createReport();
        report.generate();
    }
}

class PDFCreator extends ReportCreator {
    public Report createReport() {
        return new PDFReport();
    }
}

class ExcelCreator extends ReportCreator {
    public Report createReport() {
        return new ExcelReport();
    }
}

class HTMLCreator extends ReportCreator {
    public Report createReport() {
        return new HTMLReport();
    }
}
public class Main {

    public static void main(String[] args) {
        ReportCreator creator;
        
        creator = new PDFCreator();
        creator.generateReport();

        creator = new ExcelCreator();
        creator.generateReport();

        creator = new HTMLCreator();
        creator.generateReport();
    }
    
}
