require dags-dvb-modules.inc

COMPATIBLE_MACHINE = "^(iqonios200hd|optimussos2)$"

SRCDATE = "20170524"

SRC_URI[md5sum] = "c1768d784809cbe79aa48dfce3fdc894"
SRC_URI[sha256sum] = "69a2faf3b2c77c707740fb2abc807f21bf2e62f9c80954f2080263b8c1f264d9"

SRC_URI = "http://en3homeftp.net/release/images/oedrivers/bcmlinuxdvb_7335-${KV}-1ci-${SRCDATE}.tar.gz"
