package org.cpifppiramide.clases;

public class TestAlumno {
    private long id;
    private long fkIdTest;
    private long fkIdAlumno;

    public TestAlumno(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFkIdTest() {
        return fkIdTest;
    }

    public void setFkIdTest(long fkIdTest) {
        this.fkIdTest = fkIdTest;
    }

    public long getFkIdAlumno() {
        return fkIdAlumno;
    }

    public void setFkIdAlumno(long fkIdAlumno) {
        this.fkIdAlumno = fkIdAlumno;
    }
}
