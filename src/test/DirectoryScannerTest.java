package test;

import scanners.DirectoryScanner;

import java.io.File;

import static org.junit.Assert.*;

public class DirectoryScannerTest {

    DirectoryScanner ds;
    @org.junit.Before
    public void setUp() throws Exception {

        ds = new DirectoryScanner();
    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void testScan() throws Exception {

        ds.scan(new File("/home/reza/"), true);

    }
}