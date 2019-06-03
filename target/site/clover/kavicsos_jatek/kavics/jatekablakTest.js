var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":34,"id":389,"methods":[{"el":24,"sc":5,"sl":12},{"el":28,"sc":5,"sl":26},{"el":33,"sc":5,"sl":30}],"name":"jatekablakTest","sl":8}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_0":{"methods":[{"sl":30}],"name":"test","pass":true,"statements":[{"sl":32}]},"test_1":{"methods":[{"sl":30}],"name":"test","pass":true,"statements":[{"sl":32}]},"test_2":{"methods":[{"sl":30}],"name":"test","pass":true,"statements":[{"sl":32}]},"test_4":{"methods":[{"sl":30}],"name":"test","pass":true,"statements":[{"sl":32}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [0, 2, 4, 1], [], [0, 2, 4, 1], [], []]
