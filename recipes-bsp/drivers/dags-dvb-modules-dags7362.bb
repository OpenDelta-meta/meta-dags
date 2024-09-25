require dags-dvb-modules.inc

COMPATIBLE_MACHINE = "^(force2|force2nano|force2plus|force2se|optimussos|valalinux|tmnanom3|tmnanoseplus|tmnanosem2|tmnanosecombo|tmnanose|fusionhd|fusionhdse|purehd)$"

SRCDATE = "20180808"

SRC_URI[md5sum] = "e2244c18913cf501fb7aa2d4b0680378"
SRC_URI[sha256sum] = "d1d029be92c33a69d6a8d17d3788a9ae037dfc3697d305e0f164b5d14ff848d2"

SRC_URI = "http://en3homeftp.net/release/images/oedrivers/bcmlinuxdvb_7362-${KV}-${SRCDATE}.tar.gz"
