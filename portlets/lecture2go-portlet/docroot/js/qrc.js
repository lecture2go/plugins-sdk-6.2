adelta = [0, 11, 15, 19, 23, 27, 31, 16, 18, 20, 22, 24, 26, 28, 20, 22, 24, 24, 26, 28, 28, 22, 24, 24, 26, 26, 28, 28, 24, 24, 26, 26, 26, 28, 28, 24, 26, 26, 26, 28, 28];
vpat = [3220, 1468, 2713, 1235, 3062, 1890, 2119, 1549, 2344, 2936, 1117, 2583, 1330, 2470, 1667, 2249, 2028, 3780, 481, 4011, 142, 3098, 831, 3445, 592, 2517, 1776, 2234, 1951, 2827, 1070, 2660, 1345, 3177];
fmtword = [30660, 29427, 32170, 30877, 26159, 25368, 27713, 26998, 21522, 20773, 24188, 23371, 17913, 16590, 20375, 19104, 13663, 12392, 16177, 14854, 9396, 8579, 11994, 11245, 5769, 5054, 7399, 6608, 1890, 597, 3340, 2107];
eccblocks = [1, 0, 19, 7, 1, 0, 16, 10, 1, 0, 13, 13, 1, 0, 9, 17, 1, 0, 34, 10, 1, 0, 28, 16, 1, 0, 22, 22, 1, 0, 16, 28, 1, 0, 55, 15, 1, 0, 44, 26, 2, 0, 17, 18, 2, 0, 13, 22, 1, 0, 80, 20, 2, 0, 32, 18, 2, 0, 24, 26, 4, 0, 9, 16, 1, 0, 108, 26, 2, 0, 43, 24, 2, 2, 15, 18, 2, 2, 11, 22, 2, 0, 68, 18, 4, 0, 27, 16, 4, 0, 19, 24, 4, 0, 15, 28, 2, 0, 78, 20, 4, 0, 31, 18, 2, 4, 14, 18, 4, 1, 13, 26, 2, 0, 97, 24, 2, 2, 38, 22, 4, 2, 18, 22, 4, 2, 14, 26, 2, 0, 116, 30, 3, 2, 36, 22, 4, 4, 16, 20, 4, 4, 12, 24, 2, 2, 68, 18, 4, 1, 43, 26, 6, 2, 19, 24, 6, 2, 15, 28, 4, 0, 81, 20, 1, 4, 50, 30, 4, 4, 22, 28, 3, 8, 12, 24, 2, 2, 92, 24, 6, 2, 36, 22, 4, 6, 20, 26, 7, 4, 14, 28, 4, 0, 107, 26, 8, 1, 37, 22, 8, 4, 20, 24, 12, 4, 11, 22, 3, 1, 115, 30, 4, 5, 40, 24, 11, 5, 16, 20, 11, 5, 12, 24, 5, 1, 87, 22, 5, 5, 41, 24, 5, 7, 24, 30, 11, 7, 12, 24, 5, 1, 98, 24, 7, 3, 45, 28, 15, 2, 19, 24, 3, 13, 15, 30, 1, 5, 107, 28, 10, 1, 46, 28, 1, 15, 22, 28, 2, 17, 14, 28, 5, 1, 120, 30, 9, 4, 43, 26, 17, 1, 22, 28, 2, 19, 14, 28, 3, 4, 113, 28, 3, 11, 44, 26, 17, 4, 21, 26, 9, 16, 13, 26, 3, 5, 107, 28, 3, 13, 41, 26, 15, 5, 24, 30, 15, 10, 15, 28, 4, 4, 116, 28, 17, 0, 42, 26, 17, 6, 22, 28, 19, 6, 16, 30, 2, 7, 111, 28, 17, 0, 46, 28, 7, 16, 24, 30, 34, 0, 13, 24, 4, 5, 121, 30, 4, 14, 47, 28, 11, 14, 24, 30, 16, 14, 15, 30, 6, 4, 117, 30, 6, 14, 45, 28, 11, 16, 24, 30, 30, 2, 16, 30, 8, 4, 106, 26, 8, 13, 47, 28, 7, 22, 24, 30, 22, 13, 15, 30, 10, 2, 114, 28, 19, 4, 46, 28, 28, 6, 22, 28, 33, 4, 16, 30, 8, 4, 122, 30, 22, 3, 45, 28, 8, 26, 23, 30, 12, 28, 15, 30, 3, 10, 117, 30, 3, 23, 45, 28, 4, 31, 24, 30, 11, 31, 15, 30, 7, 7, 116, 30, 21, 7, 45, 28, 1, 37, 23, 30, 19, 26, 15, 30, 5, 10, 115, 30, 19, 10, 47, 28, 15, 25, 24, 30, 23, 25, 15, 30, 13, 3, 115, 30, 2, 29, 46, 28, 42, 1, 24, 30, 23, 28, 15, 30, 17, 0, 115, 30, 10, 23, 46, 28, 10, 35, 24, 30, 19, 35, 15, 30, 17, 1, 115, 30, 14, 21, 46, 28, 29, 19, 24, 30, 11, 46, 15, 30, 13, 6, 115, 30, 14, 23, 46, 28, 44, 7, 24, 30, 59, 1, 16, 30, 12, 7, 121, 30, 12, 26, 47, 28, 39, 14, 24, 30, 22, 41, 15, 30, 6, 14, 121, 30, 6, 34, 47, 28, 46, 10, 24, 30, 2, 64, 15, 30, 17, 4, 122, 30, 29, 14, 46, 28, 49, 10, 24, 30, 24, 46, 15, 30, 4, 18, 122, 30, 13, 32, 46, 28, 48, 14, 24, 30, 42, 32, 15, 30, 20, 4, 117, 30, 40, 7, 47, 28, 43, 22, 24, 30, 10, 67, 15, 30, 19, 6, 118, 30, 18, 31, 47, 28, 34, 34, 24, 30, 20, 61, 15, 30];
glog = [255, 0, 1, 25, 2, 50, 26, 198, 3, 223, 51, 238, 27, 104, 199, 75, 4, 100, 224, 14, 52, 141, 239, 129, 28, 193, 105, 248, 200, 8, 76, 113, 5, 138, 101, 47, 225, 36, 15, 33, 53, 147, 142, 218, 240, 18, 130, 69, 29, 181, 194, 125, 106, 39, 249, 185, 201, 154, 9, 120, 77, 228, 114, 166, 6, 191, 139, 98, 102, 221, 48, 253, 226, 152, 37, 179, 16, 145, 34, 136, 54, 208, 148, 206, 143, 150, 219, 189, 241, 210, 19, 92, 131, 56, 70, 64, 30, 66, 182, 163, 195, 72, 126, 110, 107, 58, 40, 84, 250, 133, 186, 61, 202, 94, 155, 159, 10, 21, 121, 43, 78, 212, 229, 172, 115, 243, 167, 87, 7, 112, 192, 247, 140, 128, 99, 13, 103, 74, 222, 237, 49, 197, 254, 24, 227, 165, 153, 119, 38, 184, 180, 124, 17, 68, 146, 217, 35, 32, 137, 46, 55, 63, 209, 91, 149, 188, 207, 205, 144, 135, 151, 178, 220, 252, 190, 97, 242, 86, 211, 171, 20, 42, 93, 158, 132, 60, 57, 83, 71, 109, 65, 162, 31, 45, 67, 216, 183, 123, 164, 118, 196, 23, 73, 236, 127, 12, 111, 246, 108, 161, 59, 82, 41, 157, 85, 170, 251, 96, 134, 177, 187, 204, 62, 90, 203, 89, 95, 176, 156, 169, 160, 81, 11, 245, 22, 235, 122, 117, 44, 215, 79, 174, 213, 233, 230, 231, 173, 232, 116, 214, 244, 234, 168, 80, 88, 175];
gexp = [1, 2, 4, 8, 16, 32, 64, 128, 29, 58, 116, 232, 205, 135, 19, 38, 76, 152, 45, 90, 180, 117, 234, 201, 143, 3, 6, 12, 24, 48, 96, 192, 157, 39, 78, 156, 37, 74, 148, 53, 106, 212, 181, 119, 238, 193, 159, 35, 70, 140, 5, 10, 20, 40, 80, 160, 93, 186, 105, 210, 185, 111, 222, 161, 95, 190, 97, 194, 153, 47, 94, 188, 101, 202, 137, 15, 30, 60, 120, 240, 253, 231, 211, 187, 107, 214, 177, 127, 254, 225, 223, 163, 91, 182, 113, 226, 217, 175, 67, 134, 17, 34, 68, 136, 13, 26, 52, 104, 208, 189, 103, 206, 129, 31, 62, 124, 248, 237, 199, 147, 59, 118, 236, 197, 151, 51, 102, 204, 133, 23, 46, 92, 184, 109, 218, 169, 79, 158, 33, 66, 132, 21, 42, 84, 168, 77, 154, 41, 82, 164, 85, 170, 73, 146, 57, 114, 228, 213, 183, 115, 230, 209, 191, 99, 198, 145, 63, 126, 252, 229, 215, 179, 123, 246, 241, 255, 227, 219, 171, 75, 150, 49, 98, 196, 149, 55, 110, 220, 165, 87, 174, 65, 130, 25, 50, 100, 200, 141, 7, 14, 28, 56, 112, 224, 221, 167, 83, 166, 81, 162, 89, 178, 121, 242, 249, 239, 195, 155, 43, 86, 172, 69, 138, 9, 18, 36, 72, 144, 61, 122, 244, 245, 247, 243, 251, 235, 203, 139, 11, 22, 44, 88, 176, 125, 250, 233, 207, 131, 27, 54, 108, 216, 173, 71, 142, 0];
var strinbuf = [],
    eccbuf = [],
    qrframe = [],
    framask = [],
    rlens = [];
var version, width, neccblk1, neccblk2, datablkw, eccblkwid;
var ecclevel = 1;

function setmask(x, y) {
    var bt;
    if (x > y) {
        bt = x;
        x = y;
        y = bt
    }
    bt = y;
    bt *= y;
    bt += y;
    bt >>= 1;
    bt += x;
    framask[bt] = 1
}

function putalign(x, y) {
    var j;
    qrframe[x + width * y] = 1;
    for (j = -2; j < 2; j++) {
        qrframe[(x + j) + width * (y - 2)] = 1;
        qrframe[(x - 2) + width * (y + j + 1)] = 1;
        qrframe[(x + 2) + width * (y + j)] = 1;
        qrframe[(x + j + 1) + width * (y + 2)] = 1
    }
    for (j = 0; j < 2; j++) {
        setmask(x - 1, y + j);
        setmask(x + 1, y - j);
        setmask(x - j, y - 1);
        setmask(x + j, y + 1)
    }
}

function modnn(x) {
    while (x >= 255) {
        x -= 255;
        x = (x >> 8) + (x & 255)
    }
    return x
}
var genpoly = [];

function appendrs(data, dlen, ecbuf, eclen) {
    var i, j, fb;
    for (i = 0; i < eclen; i++) {
        strinbuf[ecbuf + i] = 0
    }
    for (i = 0; i < dlen; i++) {
        fb = glog[strinbuf[data + i] ^ strinbuf[ecbuf]];
        if (fb != 255) {
            for (j = 1; j < eclen; j++) {
                strinbuf[ecbuf + j - 1] = strinbuf[ecbuf + j] ^ gexp[modnn(fb + genpoly[eclen - j])]
            }
        } else {
            for (j = ecbuf; j < ecbuf + eclen; j++) {
                strinbuf[j] = strinbuf[j + 1]
            }
        }
        strinbuf[ecbuf + eclen - 1] = fb == 255 ? 0 : gexp[modnn(fb + genpoly[0])]
    }
}

function ismasked(x, y) {
    var bt;
    if (x > y) {
        bt = x;
        x = y;
        y = bt
    }
    bt = y;
    bt += y * y;
    bt >>= 1;
    bt += x;
    return framask[bt]
}

function applymask(m) {
    var x, y, r3x, r3y;
    switch (m) {
    case 0:
        for (y = 0; y < width; y++) {
            for (x = 0; x < width; x++) {
                if (!((x + y) & 1) && !ismasked(x, y)) {
                    qrframe[x + y * width] ^= 1
                }
            }
        }
        break;
    case 1:
        for (y = 0; y < width; y++) {
            for (x = 0; x < width; x++) {
                if (!(y & 1) && !ismasked(x, y)) {
                    qrframe[x + y * width] ^= 1
                }
            }
        }
        break;
    case 2:
        for (y = 0; y < width; y++) {
            for (r3x = 0, x = 0; x < width; x++, r3x++) {
                if (r3x == 3) {
                    r3x = 0
                }
                if (!r3x && !ismasked(x, y)) {
                    qrframe[x + y * width] ^= 1
                }
            }
        }
        break;
    case 3:
        for (r3y = 0, y = 0; y < width; y++, r3y++) {
            if (r3y == 3) {
                r3y = 0
            }
            for (r3x = r3y, x = 0; x < width; x++, r3x++) {
                if (r3x == 3) {
                    r3x = 0
                }
                if (!r3x && !ismasked(x, y)) {
                    qrframe[x + y * width] ^= 1
                }
            }
        }
        break;
    case 4:
        for (y = 0; y < width; y++) {
            for (r3x = 0, r3y = ((y >> 1) & 1), x = 0; x < width; x++, r3x++) {
                if (r3x == 3) {
                    r3x = 0;
                    r3y = !r3y
                }
                if (!r3y && !ismasked(x, y)) {
                    qrframe[x + y * width] ^= 1
                }
            }
        }
        break;
    case 5:
        for (r3y = 0, y = 0; y < width; y++, r3y++) {
            if (r3y == 3) {
                r3y = 0
            }
            for (r3x = 0, x = 0; x < width; x++, r3x++) {
                if (r3x == 3) {
                    r3x = 0
                }
                if (!((x & y & 1) + !(!r3x | !r3y)) && !ismasked(x, y)) {
                    qrframe[x + y * width] ^= 1
                }
            }
        }
        break;
    case 6:
        for (r3y = 0, y = 0; y < width; y++, r3y++) {
            if (r3y == 3) {
                r3y = 0
            }
            for (r3x = 0, x = 0; x < width; x++, r3x++) {
                if (r3x == 3) {
                    r3x = 0
                }
                if (!(((x & y & 1) + (r3x && (r3x == r3y))) & 1) && !ismasked(x, y)) {
                    qrframe[x + y * width] ^= 1
                }
            }
        }
        break;
    case 7:
        for (r3y = 0, y = 0; y < width; y++, r3y++) {
            if (r3y == 3) {
                r3y = 0
            }
            for (r3x = 0, x = 0; x < width; x++, r3x++) {
                if (r3x == 3) {
                    r3x = 0
                }
                if (!(((r3x && (r3x == r3y)) + ((x + y) & 1)) & 1) && !ismasked(x, y)) {
                    qrframe[x + y * width] ^= 1
                }
            }
        }
        break
    }
    return
}
var N1 = 3,
    N2 = 3,
    N3 = 40,
    N4 = 10;

function badruns(length) {
    var i;
    var runsbad = 0;
    for (i = 0; i <= length; i++) {
        if (rlens[i] >= 5) {
            runsbad += N1 + rlens[i] - 5
        }
    }
    for (i = 3; i < length - 1; i += 2) {
        if (rlens[i - 2] == rlens[i + 2] && rlens[i + 2] == rlens[i - 1] && rlens[i - 1] == rlens[i + 1] && rlens[i - 1] * 3 == rlens[i] && (rlens[i - 3] == 0 || i + 3 > length || rlens[i - 3] * 3 >= rlens[i] * 4 || rlens[i + 3] * 3 >= rlens[i] * 4)) {
            runsbad += N3
        }
    }
    return runsbad
}

function badcheck() {
    var x, y, h, b, b1;
    var thisbad = 0;
    var bw = 0;
    for (y = 0; y < width - 1; y++) {
        for (x = 0; x < width - 1; x++) {
            if ((qrframe[x + width * y] && qrframe[(x + 1) + width * y] && qrframe[x + width * (y + 1)] && qrframe[(x + 1) + width * (y + 1)]) || !(qrframe[x + width * y] || qrframe[(x + 1) + width * y] || qrframe[x + width * (y + 1)] || qrframe[(x + 1) + width * (y + 1)])) {
                thisbad += N2
            }
        }
    }
    for (y = 0; y < width; y++) {
        rlens[0] = 0;
        for (h = b = x = 0; x < width; x++) {
            if ((b1 = qrframe[x + width * y]) == b) {
                rlens[h]++
            } else {
                rlens[++h] = 1
            }
            b = b1;
            bw += b ? 1 : -1
        }
        thisbad += badruns(h)
    }
    if (bw < 0) {
        bw = -bw
    }
    var big = bw;
    count = 0;
    big += big << 2;
    big <<= 1;
    while (big > width * width) {
        big -= width * width, count++
    }
    thisbad += count * N4;
    for (x = 0; x < width; x++) {
        rlens[0] = 0;
        for (h = b = y = 0; y < width; y++) {
            if ((b1 = qrframe[x + width * y]) == b) {
                rlens[h]++
            } else {
                rlens[++h] = 1
            }
            b = b1
        }
        thisbad += badruns(h)
    }
    return thisbad
}

function genframe(instring) {
    var x, y, k, t, v, i, j, m;
    t = instring.length;
    version = 0;
    do {
        version++;
        k = (ecclevel - 1) * 4 + (version - 1) * 16;
        neccblk1 = eccblocks[k++];
        neccblk2 = eccblocks[k++];
        datablkw = eccblocks[k++];
        eccblkwid = eccblocks[k];
        k = datablkw * (neccblk1 + neccblk2) + neccblk2 - 3 + (version <= 9);
        if (t <= k) {
            break
        }
    } while (version < 40);
    width = 17 + 4 * version;
    v = datablkw + (datablkw + eccblkwid) * (neccblk1 + neccblk2) + neccblk2;
    for (t = 0; t < v; t++) {
        eccbuf[t] = 0
    }
    strinbuf = instring.slice(0);
    for (t = 0; t < width * width; t++) {
        qrframe[t] = 0
    }
    for (t = 0; t < (width * (width + 1) + 1) / 2; t++) {
        framask[t] = 0
    }
    for (t = 0; t < 3; t++) {
        k = 0;
        y = 0;
        if (t == 1) {
            k = (width - 7)
        }
        if (t == 2) {
            y = (width - 7)
        }
        qrframe[(y + 3) + width * (k + 3)] = 1;
        for (x = 0; x < 6; x++) {
            qrframe[(y + x) + width * k] = 1;
            qrframe[y + width * (k + x + 1)] = 1;
            qrframe[(y + 6) + width * (k + x)] = 1;
            qrframe[(y + x + 1) + width * (k + 6)] = 1
        }
        for (x = 1; x < 5; x++) {
            setmask(y + x, k + 1);
            setmask(y + 1, k + x + 1);
            setmask(y + 5, k + x);
            setmask(y + x + 1, k + 5)
        }
        for (x = 2; x < 4; x++) {
            qrframe[(y + x) + width * (k + 2)] = 1;
            qrframe[(y + 2) + width * (k + x + 1)] = 1;
            qrframe[(y + 4) + width * (k + x)] = 1;
            qrframe[(y + x + 1) + width * (k + 4)] = 1
        }
    }
    if (version > 1) {
        t = adelta[version];
        y = width - 7;
        for (;;) {
            x = width - 7;
            while (x > t - 3) {
                putalign(x, y);
                if (x < t) {
                    break
                }
                x -= t
            }
            if (y <= t + 9) {
                break
            }
            y -= t;
            putalign(6, y);
            putalign(y, 6)
        }
    }
    qrframe[8 + width * (width - 8)] = 1;
    for (y = 0; y < 7; y++) {
        setmask(7, y);
        setmask(width - 8, y);
        setmask(7, y + width - 7)
    }
    for (x = 0; x < 8; x++) {
        setmask(x, 7);
        setmask(x + width - 8, 7);
        setmask(x, width - 8)
    }
    for (x = 0; x < 9; x++) {
        setmask(x, 8)
    }
    for (x = 0; x < 8; x++) {
        setmask(x + width - 8, 8);
        setmask(8, x)
    }
    for (y = 0; y < 7; y++) {
        setmask(8, y + width - 7)
    }
    for (x = 0; x < width - 14; x++) {
        if (x & 1) {
            setmask(8 + x, 6);
            setmask(6, 8 + x)
        } else {
            qrframe[(8 + x) + width * 6] = 1;
            qrframe[6 + width * (8 + x)] = 1
        }
    }
    if (version > 6) {
        t = vpat[version - 7];
        k = 17;
        for (x = 0; x < 6; x++) {
            for (y = 0; y < 3; y++, k--) {
                if (1 & (k > 11 ? version >> (k - 12) : t >> k)) {
                    qrframe[(5 - x) + width * (2 - y + width - 11)] = 1;
                    qrframe[(2 - y + width - 11) + width * (5 - x)] = 1
                } else {
                    setmask(5 - x, 2 - y + width - 11);
                    setmask(2 - y + width - 11, 5 - x)
                }
            }
        }
    }
    for (y = 0; y < width; y++) {
        for (x = 0; x <= y; x++) {
            if (qrframe[x + width * y]) {
                setmask(x, y)
            }
        }
    }
    v = strinbuf.length;
    for (i = 0; i < v; i++) {
        eccbuf[i] = strinbuf.charCodeAt(i)
    }
    strinbuf = eccbuf.slice(0);
    x = datablkw * (neccblk1 + neccblk2) + neccblk2;
    if (v >= x - 2) {
        v = x - 2;
        if (version > 9) {
            v--
        }
    }
    i = v;
    if (version > 9) {
        strinbuf[i + 2] = 0;
        strinbuf[i + 3] = 0;
        while (i--) {
            t = strinbuf[i];
            strinbuf[i + 3] |= 255 & (t << 4);
            strinbuf[i + 2] = t >> 4
        }
        strinbuf[2] |= 255 & (v << 4);
        strinbuf[1] = v >> 4;
        strinbuf[0] = 64 | (v >> 12)
    } else {
        strinbuf[i + 1] = 0;
        strinbuf[i + 2] = 0;
        while (i--) {
            t = strinbuf[i];
            strinbuf[i + 2] |= 255 & (t << 4);
            strinbuf[i + 1] = t >> 4
        }
        strinbuf[1] |= 255 & (v << 4);
        strinbuf[0] = 64 | (v >> 4)
    }
    i = v + 3 - (version < 10);
    while (i < x) {
        strinbuf[i++] = 236;
        strinbuf[i++] = 17
    }
    genpoly[0] = 1;
    for (i = 0; i < eccblkwid; i++) {
        genpoly[i + 1] = 1;
        for (j = i; j > 0; j--) {
            genpoly[j] = genpoly[j] ? genpoly[j - 1] ^ gexp[modnn(glog[genpoly[j]] + i)] : genpoly[j - 1]
        }
        genpoly[0] = gexp[modnn(glog[genpoly[0]] + i)]
    }
    for (i = 0; i <= eccblkwid; i++) {
        genpoly[i] = glog[genpoly[i]]
    }
    k = x;
    y = 0;
    for (i = 0; i < neccblk1; i++) {
        appendrs(y, datablkw, k, eccblkwid);
        y += datablkw;
        k += eccblkwid
    }
    for (i = 0; i < neccblk2; i++) {
        appendrs(y, datablkw + 1, k, eccblkwid);
        y += datablkw + 1;
        k += eccblkwid
    }
    y = 0;
    for (i = 0; i < datablkw; i++) {
        for (j = 0; j < neccblk1; j++) {
            eccbuf[y++] = strinbuf[i + j * datablkw]
        }
        for (j = 0; j < neccblk2; j++) {
            eccbuf[y++] = strinbuf[(neccblk1 * datablkw) + i + (j * (datablkw + 1))]
        }
    }
    for (j = 0; j < neccblk2; j++) {
        eccbuf[y++] = strinbuf[(neccblk1 * datablkw) + i + (j * (datablkw + 1))]
    }
    for (i = 0; i < eccblkwid; i++) {
        for (j = 0; j < neccblk1 + neccblk2; j++) {
            eccbuf[y++] = strinbuf[x + i + j * eccblkwid]
        }
    }
    strinbuf = eccbuf;
    x = y = width - 1;
    k = v = 1;
    m = (datablkw + eccblkwid) * (neccblk1 + neccblk2) + neccblk2;
    for (i = 0; i < m; i++) {
        t = strinbuf[i];
        for (j = 0; j < 8; j++, t <<= 1) {
            if (128 & t) {
                qrframe[x + width * y] = 1
            }
            do {
                if (v) {
                    x--
                } else {
                    x++;
                    if (k) {
                        if (y != 0) {
                            y--
                        } else {
                            x -= 2;
                            k = !k;
                            if (x == 6) {
                                x--;
                                y = 9
                            }
                        }
                    } else {
                        if (y != width - 1) {
                            y++
                        } else {
                            x -= 2;
                            k = !k;
                            if (x == 6) {
                                x--;
                                y -= 8
                            }
                        }
                    }
                }
                v = !v
            } while (ismasked(x, y))
        }
    }
    strinbuf = qrframe.slice(0);
    t = 0;
    y = 30000;
    for (k = 0; k < 8; k++) {
        applymask(k);
        x = badcheck();
        if (x < y) {
            y = x;
            t = k
        }
        if (t == 7) {
            break
        }
        qrframe = strinbuf.slice(0)
    }
    if (t != k) {
        applymask(t)
    }
    y = fmtword[t + ((ecclevel - 1) << 3)];
    for (k = 0; k < 8; k++, y >>= 1) {
        if (y & 1) {
            qrframe[(width - 1 - k) + width * 8] = 1;
            if (k < 6) {
                qrframe[8 + width * k] = 1
            } else {
                qrframe[8 + width * (k + 1)] = 1
            }
        }
    }
    for (k = 0; k < 7; k++, y >>= 1) {
        if (y & 1) {
            qrframe[8 + width * (width - 7 + k)] = 1;
            if (k) {
                qrframe[(6 - k) + width * 8] = 1
            } else {
                qrframe[7 + width * 8] = 1
            }
        }
    }
    return qrframe
}
var wd, ht, qrc;

function setupqr() {
    wd = 395;
    ht = 395;
    mp = document.getElementById("mapcanv");
    var elem = document.getElementById("qrcanv");
    if (elem != null) {
    	qrc = elem.getContext("2d");
    	qrc.canvas.width = wd;
    	qrc.canvas.height = ht;
    	qrc.fillStyle = "#eee";
    	qrc.fillRect(0, 0, wd, ht);
    	doqr(window.location.href)
    }
}

function doqr(url) {
    d = document;
    ecclevel = 2;
    qf = genframe(url);
    qrc.lineWidth = 1;
    var i, j;
    px = wd;
    if (ht < wd) {
        px = ht
    }
    px /= width + 10;
    px = Math.round(px - 0.5);
    qrc.clearRect(0, 0, wd, ht);
    qrc.fillStyle = "#fff";
    qrc.fillRect(0, 0, px * (width + 8), px * (width + 8));
    qrc.fillStyle = "#000";
    for (i = 0; i < width; i++) {
        for (j = 0; j < width; j++) {
            if (qf[j * width + i]) {
                qrc.fillRect(px * (4 + i), px * (4 + j), px, px)
            }
        }
    }
}
window.onload = setupqr;

$("body").scroll