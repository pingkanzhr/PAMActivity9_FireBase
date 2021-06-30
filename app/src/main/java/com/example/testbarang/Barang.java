package com.example.testbarang;

import java.io.Serializable;

public class Barang implements Serializable {
    private String nama;
    private String telp;
    private String kode;

    public Barang() {
    }

    public Barang(String nm, String tlp) {
        this.nama = nm;
        this.telp = tlp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    @Override
    public String toString() {
        return "Barang{" +
                "nama='" + nama + '\'' +
                ", telp='" + telp + '\'' +
                ", kode='" + kode + '\'' +
                '}';
    }
}