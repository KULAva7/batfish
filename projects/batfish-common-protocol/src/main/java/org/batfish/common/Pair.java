package org.batfish.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

/** A generic pair of comparable objects */
@ParametersAreNonnullByDefault
@Deprecated // Don't be lazy.
public class Pair<T1 extends Comparable<? super T1>, T2 extends Comparable<? super T2>>
    implements Serializable, Comparable<Pair<T1, T2>> {

  private static final long serialVersionUID = 1L;

  @Nonnull private final T1 _first;
  @Nullable private final T2 _second;

  public Pair(T1 t1, @Nullable T2 t2) {
    _first = t1;
    _second = t2;
  }

  @Override
  public int compareTo(Pair<T1, T2> rhs) {
    return Comparator.comparing(Pair<T1, T2>::getFirst)
        .thenComparing(Pair::getSecond, Comparator.nullsFirst(T2::compareTo))
        .compare(this, rhs);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    } else if (!(obj instanceof Pair)) {
      return false;
    }

    Pair<?, ?> other = (Pair<?, ?>) obj;
    return Objects.equals(_first, other._first) && Objects.equals(_second, other._second);
  }

  @Nonnull
  @JsonIgnore
  public final T1 getFirst() {
    return _first;
  }

  @JsonIgnore
  @Nullable
  public final T2 getSecond() {
    return _second;
  }

  @Override
  public int hashCode() {
    return Objects.hash(_first, _second);
  }

  @Override
  public String toString() {
    return "<" + _first + ":" + _second + ">";
  }
}
