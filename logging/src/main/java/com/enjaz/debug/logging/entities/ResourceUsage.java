package com.enjaz.debug.logging.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import java.util.Date;

@Entity(tableName = "ResourceUsage")
@TypeConverters(DateConverter.class)
public class ResourceUsage {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int memoryId;
    private int totalMemory;
    private int freeMemory;
    private int usedMemory;
    private int maxHeapSize;
    private int availableHeapSize;
    private Date date;

    public ResourceUsage( int totalMemory, int freeMemory, int usedMemory, int maxHeapSize, int availableHeapSize, Date date) {

        this.totalMemory = totalMemory;
        this.freeMemory = freeMemory;
        this.usedMemory = usedMemory;
        this.maxHeapSize = maxHeapSize;
        this.availableHeapSize = availableHeapSize;
        this.date = date;
    }

    @NonNull
    public int getMemoryId() {
        return memoryId;
    }

    public void setMemoryId(@NonNull int memoryId) {
        this.memoryId = memoryId;
    }

    public int getTotalMemory() {
        return totalMemory;
    }

    public void setTotalMemory(int totalMemory) {
        this.totalMemory = totalMemory;
    }

    public int getFreeMemory() {
        return freeMemory;
    }

    public void setFreeMemory(int freeMemory) {
        this.freeMemory = freeMemory;
    }

    public int getUsedMemory() {
        return usedMemory;
    }

    public void setUsedMemory(int usedMemory) {
        this.usedMemory = usedMemory;
    }

    public int getMaxHeapSize() {
        return maxHeapSize;
    }

    public void setMaxHeapSize(int maxHeapSize) {
        this.maxHeapSize = maxHeapSize;
    }

    public int getAvailableHeapSize() {
        return availableHeapSize;
    }

    public void setAvailableHeapSize(int availableHeapSize) {
        this.availableHeapSize = availableHeapSize;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}