require dags-dvb-modules.inc

COMPATIBLE_MACHINE = "^(force2plushv|lunix|purehdse|lunixco)$"

SRCDATE = "20200324"

SRC_URI[md5sum] = "f5f819843c5a9bec86d463ce947bb9ea"
SRC_URI[sha256sum] = "df455a30190e4e62168af25a510a61ca6622042b43f4d7a27944a3897b25dceb"

SRC_URI = "http://en3homeftp.net/release/images/oedrivers/bcmlinuxdvb_73625-${KV}-${SRCDATE}.tar.gz"
