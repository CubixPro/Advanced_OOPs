from nose.tools import assert_equal

from parameterized import parameterized

import math

# Values in the form
# (x, y, expected after finding x^y)
@parameterized ([
    (2, 2, 4),
    (2, 3, 8),
    (1, 9, 1),
    (0, 9, 0),
    (2, 4, 11)
])

# function checking whether the test 
# outputs are as expected
def test_pow(base, exponent, expected):
    assert_equal(math.pow(base, exponent), expected)

# to run this program use
# nosetests -v PLA2_13.py 