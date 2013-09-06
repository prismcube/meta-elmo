FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI = "http://samba.org/samba/ftp/stable/samba-${PV}.tar.gz \
    file://volatiles.03_samba \
    file://smb.conf \
    file://init.samba \
    file://init.winbind \
    file://tdb.pc \
    file://config-lfs.patch \
    file://quota.patch;striplevel=0 \
    file://config-h.patch \
    file://fhs-filespaths.patch;patchdir=.. \
    file://installswat.sh.patch;patchdir=.. \
    file://pam-examples.patch;patchdir=.. \
    file://smbclient-pager.patch;patchdir=.. \
    file://undefined-symbols.patch;patchdir=.. \
    file://usershare.patch;patchdir=.. \
    file://smbtar-bashism.patch;patchdir=.. \
    file://dont-build-VFS-examples.patch;patchdir=.. \
    file://bug_221618_precise-64bit-prototype.patch;patchdir=.. \
    file://bug_598313_upstream_7499-nss_wins-dont-clobber-daemons-logs.patch;patchdir=.. \
    file://bug_387266_upstream_4104_mention-kerberos-in-smbspool-manpage.patch;patchdir=.. \
    file://bug_604768_upstream_7826_drop-using-samba-link.patch;patchdir=.. \
    file://bug_604768_upstream_7826_fix-WHATSNEW-link.patch;patchdir=.. \
    file://waf-as-source.patch;patchdir=.. \
    file://smbtorture-manpage.patch;patchdir=.. \
    file://libutil_drop_AI_ADDRCONFIG.patch;patchdir=.. \
    file://shadow_copy2_backport.patch;patchdir=.. \
    file://only_export_public_symbols.patch;patchdir=.. \
    file://configure-disable-getaddrinfo-cross.patch;patchdir=.. \
    file://configure-disable-core_pattern-cross-check.patch;patchdir=.. \
"
