import sys

def find(bb):
    ll = len(bb)
    bb.sort()
    if ll == 1:
        return bb[0]
    elif ll == 2:
        return bb[1] - bb[0]
    else:
        new = bb[ll - 1] - bb[ll - 2]
        bb[ll - 2:ll] = []
        bb.append(new)
        return find(bb)

test = int(sys.stdin.readline().strip())
aa = []
for _ in range(test):
    aa.append(int(sys.stdin.readline().strip()))
print(find(aa))
