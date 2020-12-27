package com.chess.common;

public class Coordinate {
  private final File file;
  private final int rank;

  public Coordinate(File file, int rank) {
    super();
    this.file = file;
    this.rank = rank;
  }

  public File getFile() {
    return file;
  }

  public int getRank() {
    return rank;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((file == null) ? 0 : file.hashCode());
    result = prime * result + rank;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Coordinate other = (Coordinate) obj;
    if (file != other.file)
      return false;
    if (rank != other.rank)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return file + "" + rank;
  }
}
