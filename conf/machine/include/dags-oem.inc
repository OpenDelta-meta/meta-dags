# We know about rtc
MACHINE_FEATURES_BACKFILL_CONSIDERED += "rtc"

BOX_BRAND = "dags"

MACHINE_FEATURES += "alsa hdmicec switchoff textlcd ci dags HDMI"

BOOTLOGO_FILENAME = "splash.bmp"

DVBPROVIDER = "kernel"
DVBSKYPROVIDER = "kernel"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "\
	dags-shutdown \
	gstreamer1.0-plugin-dvbmediasink \
	gstreamer1.0-libav \
	${@bb.utils.contains('MACHINE_FEATURES', 'swap', 'dags-swapcreate', '',d)} \
	"

GLIBC_EXTRA_OECONF = "--with-tls"
DVBMEDIASINK_CONFIG = "--with-dags --with-pcm --with-eac3 --with-amr --with-wmv"

PREFERRED_PROVIDER_virtual/kernel = "linux-dags"

PREFERRED_PROVIDER_virtual/blindscan-dvbs = "dags-blindscan-utils"

require conf/machine/include/soc-family.inc

BLINDSCAN_BINARY = "dags_blindscan"

RCNAME ?= "optimuss1"

PREFERRED_VERSION_linux-dags = "${KERNELVERSION}"
