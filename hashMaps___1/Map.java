package hashMaps___1;
import java.util.ArrayList;
public class Map<K,V> {

	ArrayList<MapNode<K,V>> buckets;
	int count;
	int numBuckets;

	public Map() {
		buckets =new ArrayList<>();
		numBuckets=5;
		for(int i=0;i<numBuckets;i++) {
			buckets.add(null);
		}
	}

	private int getBucketIndex(K key) {
		int hashCode=key.hashCode();
		int index=hashCode%numBuckets;
		return index;
	}
	private void reHash() {
		ArrayList<MapNode<K,V>> temp=buckets;

		buckets=new ArrayList<>();
		for(int i=0;i<2*numBuckets;i++) {
			buckets.add(null);
		}
		count=0;
		numBuckets=numBuckets*2;
		for(int i=0;i<temp.size();i++) {
			MapNode<K,V> head=temp.get(i);
			while(head!=null) {
				insert(head.key,head.value);
				head=head.next;
			}
		}
	}
    public double loadFactor() {
    	return ((double)count)/numBuckets;
    }
	public void insert(K key,V val) {
		int bucketIndex=getBucketIndex(key);

		// firstly we are checking if the key is present earlier ot not
		// if present then we are updating its value
		MapNode<K, V> head=buckets.get(bucketIndex);
		while(head!=null) {
			// here we are comparing the data but if we write == it can compare the address as the key is a string.
			if(head.key.equals(key)) {
				head.value=val;
				return;
			}
			head=head.next;
		}

		head=buckets.get(bucketIndex);
		MapNode<K,V> toAdd=new MapNode<>(key,val);

		// here we are inserting nodes from the front side.
		toAdd.next=head;
		buckets.set(bucketIndex, toAdd);
		count++;

		double loadFactor=((double)count)/numBuckets;
		if(loadFactor > 0.7) {
			reHash();
		}
	}

	public boolean isPresent(K key) {
		int index=getBucketIndex(key);
		MapNode<K,V> head =buckets.get(index);
		while(head!=null) {
			if(head.key.equals(key)) {
				return true;
			}
			head=head.next;
		}
		return false;			
	}

	public V delete(K key) {

		int index=getBucketIndex(key);
		MapNode<K,V> head =buckets.get(index);
		MapNode<K,V> prev=null;
		while(head!=null) {
			if(head.key.equals(key)) {
				if(prev!=null) {
					prev.next=head.next;
				}
				else {
					buckets.set(index, head.next);
				}
				count--;
				return head.value;
			}
			prev=head;
			head=head.next;
		}
		return null;
	}

	public V getValue(K key) {
		//		if(isPresent(key)==false) {
		//			System.out.println("key doesnt exist");
		//		}
		//	V val=null;
		int index=getBucketIndex(key);
		MapNode<K,V> head =buckets.get(index);
		while(head!=null) {
			if(head.key.equals(key)) {
				return head.value;

			}
			head=head.next;
		}
		return null;
	}

	public int size() {
		return count;
	}




}
