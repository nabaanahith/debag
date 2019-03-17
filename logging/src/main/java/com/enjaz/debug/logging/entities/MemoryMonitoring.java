package com.enjaz.debug.logging.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "MemoryMonitoring")
public class MemoryMonitoring {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int memoryId;
    private long totalMemory;
    private long freeMemory;
    private long usedMemory;
    private long maxHeapSize;
    private long availableHeapSize;

    public MemoryMonitoring(@NonNull int memoryId, long totalMemory, long freeMemory, long usedMemory, long maxHeapSize, long availableHeapSize) {
        this.memoryId = memoryId;
        this.totalMemory = totalMemory;
        this.freeMemory = freeMemory;
        this.usedMemory = usedMemory;
        this.maxHeapSize = maxHeapSize;
        this.availableHeapSize = availableHeapSize;
    }

    @NonNull
    public int getMemoryId() {
        return memoryId;
    }

    public void setMemoryId(@NonNull int memoryId) {
        this.memoryId = memoryId;
    }

    public long getTotalMemory() {
        return totalMemory;
    }

    public void setTotalMemory(long totalMemory) {
        this.totalMemory = totalMemory;
    }

    public long getFreeMemory() {
        return freeMemory;
    }

    public void setFreeMemory(long freeMemory) {
        this.freeMemory = freeMemory;
    }

    public long getUsedMemory() {
        return usedMemory;
    }

    public void setUsedMemory(long usedMemory) {
        this.usedMemory = usedMemory;
    }

    public long getMaxHeapSize() {
        return maxHeapSize;
    }

    public void setMaxHeapSize(long maxHeapSize) {
        this.maxHeapSize = maxHeapSize;
    }

    public long getAvailableHeapSize() {
        return availableHeapSize;
    }

    public void setAvailableHeapSize(long availableHeapSize) {
        this.availableHeapSize = availableHeapSize;
    }
}
