package descargas;

public interface Identificable<T extends Comparable<T>> extends Comparable<Identificable<T>>{

	T getId();

	@Override
	default int compareTo(Identificable<T> identificable) {
		return getId().compareTo(identificable.getId());
	}
}