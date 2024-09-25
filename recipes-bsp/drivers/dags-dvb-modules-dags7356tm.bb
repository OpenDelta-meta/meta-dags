require dags-dvb-modules.inc

COMPATIBLE_MACHINE = "^(tmnano3t|tmnano2super)$"

SRCDATE = "20170524"

SRC_URI[md5sum] = "3d4b4c040cfa7dd4e5c6724fe2ad6080"
SRC_URI[sha256sum] = "88fdb1d1f341f38893c33ab31bee69af1ee1e13f6e50636718964dcfaa6a9ee1"

SRC_URI = "http://en3homeftp.net/release/images/oedrivers/bcmlinuxdvb_7356-${KV}-tmnano3t-${SRCDATE}.tar.gz"
