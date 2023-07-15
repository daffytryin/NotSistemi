public class Student {
    String name,stuNo;
    int classes;
    Course mat;
    Course fizik;
    Course kimya;
    double avarage;
    boolean isPass;


    Student(String name, int classes, String stuNo, Course mat,Course fizik,Course kimya) {
        this.name = name;
        this.classes = classes;
        this.stuNo = stuNo;
        this.mat = mat;
        this.fizik = fizik;
        this.kimya = kimya;
        calcAvarage();
        this.isPass = false;
    }


    public void addBulkExamNote(int mat, int fizik, int kimya, int matOral, int fizOral, int kimOral) {

        if (mat >= 0 && mat <= 100 && matOral>=0 && matOral<=100) {
            this.mat.note = mat;
            this.mat.oralNote = matOral;
        }

        if (fizik >= 0 && fizik <= 100 && fizOral>=0 && fizOral<=100) {
            this.fizik.note = fizik;
            this.fizik.oralNote = fizOral;
        }

        if (kimya >= 0 && kimya <= 100 && kimOral>=0 && kimOral<=100) {
            this.kimya.note = kimya;
            this.kimya.oralNote = kimOral;
        }

    }

    public void isPass() {
        if (this.mat.note == 0 || this.fizik.note == 0 || this.kimya.note == 0) {
            System.out.println("Notlar tam olarak girilmemiş");
        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Ortalama : " + this.avarage);
            if (this.isPass) {
                System.out.println("Sınıfı Geçti. ");
            } else {
                System.out.println("Sınıfta Kaldı.");
            }
        }
    }

    public void calcAvarage() {
        double mat;
        double fizik;
        double kimya;
        mat = this.mat.note * 0.8 + this.mat.oralNote * 0.2;
        kimya = this.kimya.note * 0.8 + this.kimya.oralNote * 0.2;
        fizik = (this.fizik.note * 0.8 + this.fizik.oralNote * 0.2);
        this.avarage = (mat + kimya + fizik) / 3;
    }

    public boolean isCheckPass() {
        calcAvarage();
        return this.avarage > 55;
    }

    public void printNote(){
        System.out.println("=========================");
        System.out.println("Öğrenci : " + this.name);
        System.out.println("Matematik Notu : " + this.mat.note + " & Sözlü Notu : " +this.mat.oralNote);
        System.out.println("Fizik Notu : " + this.fizik.note + " & Sözlü Notu : " +this.fizik.oralNote);
        System.out.println("Kimya Notu : " + this.kimya.note + " & Sözlü Notu : " +this.kimya.oralNote);
    }

}
