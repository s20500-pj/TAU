package org.obstacles.models;

import lombok.Data;

@Data
public class Position {
    private int row;
    private int col;

    public Position() {
        this.row = 0;
        this.col = 0;
    }
}
