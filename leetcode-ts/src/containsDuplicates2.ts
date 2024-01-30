function containsNearbyDuplicate(nums: number[], k: number): boolean {
  const set = new Set<number>();

  for (let i = 0; i < nums.length; i++) {
    const it = nums[i];

    if (i > k) {
      set.delete(nums[i - k - 1]);
    }

    if (set.has(it)) {
      return true;
    }

    set.add(it);
  }

  return false;
}
