function isHappy(n: number): boolean {
  let slow = n;
  let fast = n;

  do {
    slow = tryToMakeHappy(slow);
    fast = tryToMakeHappy(tryToMakeHappy(fast));
  } while (slow !== fast && fast !== 1);

  return fast === 1;
}

function tryToMakeHappy(n: number) {
  let it = n;
  let res = 0;

  while (it > 0) {
    let digit = it % 10;
    res += digit * digit;
    it = Math.floor(it / 10);
  }

  return res;
}
