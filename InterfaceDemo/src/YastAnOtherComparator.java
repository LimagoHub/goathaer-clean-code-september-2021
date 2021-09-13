public interface YastAnOtherComparator<T> {

    boolean eq(T t1, T t2);
    boolean lt(T t1, T t2);

    default boolean le(T t1, T t2) {
        return eq(t1,t2) ||lt(t1, t2);
    }

}
