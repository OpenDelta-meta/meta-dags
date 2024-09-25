require dags-dvb-modules.inc

COMPATIBLE_MACHINE = "^(worldvisionf1|worldvisionf1plus)$"

SRCDATE = "20171201"

SRC_URI[md5sum] = "842566ec81722539b7211d9c13ab39c9"
SRC_URI[sha256sum] = "fa1bd1a9b79644c3ec4687dc83dfbb87bb1f5f68194e9baa4ec8d5527339b9f2"

SRC_URI = "http://en3homeftp.net/release/images/oedrivers/bcmlinuxdvb_f1_7356-${KV}-${SRCDATE}.tar.gz"
