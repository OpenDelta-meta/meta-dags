require dags-dvb-modules.inc

COMPATIBLE_MACHINE = "^(force1|force1plus|optimussos2plus|optimussos3plus|optimussos1plus)$"

SRCDATE = "20170524"

SRC_URI[md5sum] = "5e2ec4afa56361c9bb274e1b075a6e76"
SRC_URI[sha256sum] = "721a4c5c1027aa5265c75d778433ff1add0fcd74278e6af05c16f8d81a8581df"

SRC_URI = "http://en3homeftp.net/release/images/oedrivers/bcmlinuxdvb_7356-${KV}-${SRCDATE}.tar.gz"
